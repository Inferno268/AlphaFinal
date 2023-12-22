
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce


/**
 * Coroutine that produces infinit stream of timetables and sends it to the channel
 */
fun CoroutineScope.produceTimetables() = produce<Array<Array<Lesson>>> {
    val generator = Generator()
    val timetable = Timetable(arrayOf())
    timetable.fillTable()
    while (true) send(generator.generateTimeTable(timetable))
}
/**
 * Coroutine that receives timetables from the channel and evaluates them
 */
fun CoroutineScope.evaluateTimetables(timetables: ReceiveChannel<Array<Array<Lesson>>>): ReceiveChannel<UShort> = produce {
    var evaluator = Evaluator()

    for (timetable in timetables) send(evaluator.evaluate(timetable))
}


fun main(args: Array<String>) = runBlocking {

    val watchdog = Watchdog()

    val timetables = produceTimetables()
    val evaluations = evaluateTimetables(timetables)

    watchdog.setOnTimerFinishedCallback {  }

    println("Program started! Type -s to start or -h for help")

    var command = readLine()
    var maxTime: Long = 10L // Default max time

    while (command != "-s") {
        when (command) {
            "-h" -> {
                println("Help: \n-s: Start the program\n-h: Show the help message \n-q: Quit the program\n-i: Insert a new timetable \n-t: Set max runtime")
            }
            "-q" -> {
                println("Program stopped!")
                System.exit(0)
            }
            "-i" -> {
                println("It looks like you are tryng to insert a new timetable. This feature is not implemented yet.")

            }
            "-t" -> {
                println("Enter max time (in seconds): ")
                maxTime = readLine()?.toLongOrNull() ?: 60L
                watchdog.setMaxTime(maxTime)
                println("Enter -s to start!")
            }
            else -> {
                println("Unknown command. Type -s to start or -h for help")
            }
        }
        command = readLine()
    }
    println("Program started!")
    watchdog.startTimer()

    while (true) {
        try {

            evaluations.receive()

        }
        catch (e: Exception) {
            println("Timeout!")
        }
    }
}

