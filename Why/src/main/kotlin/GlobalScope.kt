class GlobalScope {
    /**
     * Global variables for the whole program
     */
    companion object {
        var bestTimetable: MutableMap<Array<Array<Lesson>>, UShort> = HashMap()
        var listOfTimetables: MutableList<Array<Array<Lesson>>> = ArrayList()
        val setOfHashCodes: MutableSet<Int> = HashSet()
        val profileSubjects : MutableList<UByte> = ArrayList()
        val listOfTeachers : MutableMap<UByte, String> = HashMap()
        val listOfSubjects: MutableMap<UByte, String> = HashMap()

        /**
         * Function that will print results from map. For example the best timetable.
         */
        fun printMap(number: UByte, map: Map<UByte, String>): String {
            return if (map.containsKey(number)) {
                val result = map[number]
                result.toString()
            } else {
                " "
            }
        }
    }

}