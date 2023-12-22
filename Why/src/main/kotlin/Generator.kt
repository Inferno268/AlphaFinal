class Generator {

    /**
     * Generates a new timetable based on the given timetable.
     * Timetable is saved only if it is unique.
     * @param timetable the timetable that will be used to generate a new timetable
     * @return the new timetable
     */
    fun generateTimeTable(timetable: Timetable): Array<Array<Lesson>> {
        timetable.shuffleTable()
        var hashCode = timetable.table.contentDeepHashCode()
        GlobalScope.listOfTimetables.add(timetable.table)
        if (!GlobalScope.setOfHashCodes.contains(hashCode)) {
            GlobalScope.setOfHashCodes.add(hashCode)
        }

        return timetable.table
    }

}
