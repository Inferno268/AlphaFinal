# Timetable generator 
- Application that generates timetables based on initialy inserted timetable and then evaluates them
- Tech stack : 
	- [Kotlin](https://kotlinlang.org/)
	- [Maven](https://maven.apache.org/)

### Project folder structure 
- Runnable  file is located inside 
```bash
    src
     | → main
     | |→ kotlin
	 | | |→ Main.kt
```
- Runnable file for unit tests is located in
```bash
    src
     | → test
     | |→ kotlin
	 | | |→ EvaluatorTest
```

### Project structure
- The whole project is based on kotlin [Channel](https://kotlinlang.org/docs/channels.html) and pipelines
	- There are 2 coroutines, both have their own methods and are connected by a special channel where one of the coroutines creates an infinite stream of values and sends them to the other. 
- The program then handles the evaluated timetables from the second coroutine and display the best one along with the count of generated and evaluated timetables and the count of better timetables than the initialy inserted.
- The code is design to take as less memory as possible so every variable if possible is stored as UByte or UShort. Every value has a string assigned to it inside a map. Filling of the map is located in Timetable.kt inside FillTable function.
- There is another thread that watches over the whole porgram. The Watchdog.kt handles for how long should the program run. 

### Evaluator rules
- The evaluator has set of rules based on which it gives score. Here are 2 of the custom rules I made up :
1. If 6th lesson or later is in the 4th floor the timetable gets minus points
2. If on friday there is more that 5 lessons the timetable gets minus points

# How to run the program
 1. Download the file from 
  ```bash
    Why
     | → out
     | |→ artifacts
     | | |→ Why_jar2
```
2. Open terminal on the folder where is the file and run :
```bash
java -jar Why_jar2.jar
```
3. Run ***-s*** for start or ***-h*** for help
