class Evaluator {
    companion object {
        var counter: UShort = 0u
    }
    /**
     * Function that will evaluate the timetable on set of rules listed in the README.md file
     */
    fun evaluate(timetable: Array<Array<Lesson>>): UShort {
        var result: UShort = 50.toUShort()
        var bestScore: UShort = 0.toUShort()
        val point: UShort = 1.toUShort()
        val unlikedClassRoom = 0u.toUByte()
        val unlikedTeacher = 14u.toUByte()
        val likedTeacher = 7u.toUByte()




        for ((key, value) in GlobalScope.bestTimetable.entries) {
            bestScore = value
        }

        for (i in timetable.indices) {
            for (n in timetable[i].indices) {
                val lesson = timetable[i][n]
                val numberOfSameLessons = timetable[i].count { it.name == lesson.name }
                val numberOfSameLessonsNotTheoretical = timetable[i].count { it.name == lesson.name && !lesson.theoretical}
                val numberOfSameLessonsTheoretical = timetable[i].count { it.name == lesson.name && lesson.theoretical}
                val numberOfUnlikedTeacher = timetable[i].count { it.teacher == unlikedTeacher}
                val numberOfLikedTeacher = timetable[i].count { it.teacher == likedTeacher}
                if (n < 1 || n > 7 && timetable[i][8].name != 0u.toUByte() && timetable[i][9].name != 0u.toUByte()) {
                    result = (result - point).toUShort()
                } else {
                    result = (result + point).toUShort()
                }
                if (numberOfSameLessons > 1 && lesson.classRoom != 0.toUByte()) {
                    if (n > 0 && lesson.name != timetable[i][n - 1].name || n < timetable.size -1  && lesson.name != timetable[i][n + 1].name) {
                        result = (result - point).toUShort()
                    }
                    else {
                        result = (result + point).toUShort()
                    }
                }
                if (n > 0 && lesson.classRoom != timetable[i][n - 1].classRoom || n < timetable.size -1  && lesson.classRoom != timetable[i][n + 1].classRoom) {
                    if (n > 0 && lesson.floor != timetable[i][n - 1].floor || n < timetable.size -1 && lesson.floor != timetable[i][n + 1].floor) {
                        result = (result + 2u * point).toUShort()
                    }
                    else {
                        result = (result + point).toUShort()
                    }
                }
                if (timetable[i][4].name != 0u.toUByte() || timetable[i][5].name != 0u.toUByte() || timetable[i][6].name != 0u.toUByte() || timetable[i][7].name != 0u.toUByte()) {
                    result = (result - point).toUShort()
                }
                else {
                    result = (result + point).toUShort()
                }
                if (n > 5 && timetable[i][6].name != 0u.toUByte() || timetable[i][7].name != 0u.toUByte() || timetable[i][8].name != 0u.toUByte() || timetable[i][9].name != 0u.toUByte()) {
                    result = (result - point).toUShort()
                }
                else {
                    result = (result + point).toUShort()
                }
                if (GlobalScope.profileSubjects.contains(timetable[i][0].name) || GlobalScope.profileSubjects.contains(timetable[i][4].name)  || GlobalScope.profileSubjects.contains(timetable[i][6].name) || GlobalScope.profileSubjects.contains(timetable[i][7].name) || GlobalScope.profileSubjects.contains(timetable[i][4].name) || GlobalScope.profileSubjects.contains(timetable[i][5].name) || GlobalScope.profileSubjects.contains(timetable[i][6].name) || GlobalScope.profileSubjects.contains(timetable[i][7].name) || GlobalScope.profileSubjects.contains(timetable[i][8].name) || GlobalScope.profileSubjects.contains(timetable[i][9].name)){
                    result = (result - point).toUShort()
                }
                else if (n > 4 && lesson.name == 3u.toUByte() || lesson.name == 4u.toUByte() || lesson.name == 8u.toUByte()){
                    result = (result - point).toUShort()
                }
                else {
                    result = (result + point).toUShort()
                }
                if (n >5 && lesson.floor > 3.toUByte()){
                    result = (result - point).toUShort()
                }
                else {
                    result = (result + point).toUShort()
                }
                if (lesson.classRoom == unlikedClassRoom){
                    result = (result - point).toUShort()
                }
                else {
                    result = (result + point).toUShort()
                }
                if (numberOfUnlikedTeacher > 1 ){
                    result = (result - point).toUShort()
                }
                else{
                    result = (result + point).toUShort()
                }
                if (numberOfLikedTeacher > 1 ){
                    result = (result + point).toUShort()
                }
                //partially generated by IntelliJ IDEA
                if ((timetable.getOrNull(4)?.size
                        ?: 0) > 5 && timetable[4][6].name != 0u.toUByte() || timetable[4][7].name != 0u.toUByte() || timetable[4][8].name != 0u.toUByte() || timetable[4][9].name != 0u.toUByte()
                ) {
                    result = (result - point).toUShort()
                }
                else {
                    result = (result + point).toUShort()

                }
                if (numberOfSameLessonsNotTheoretical > 1 && n > 1 && timetable[i][n - 1].name == lesson.name && timetable[i][n - 1].theoretical || n < timetable.size -1  && lesson.name == timetable[i][n + 1].name && timetable[i][n + 1].theoretical) {
                    result = (result - point).toUShort()
                }
                else {
                    result = (result + point).toUShort()
                }
                if (numberOfSameLessonsTheoretical > 1 && n > 1 && timetable[i][n - 1].name == lesson.name && timetable[i][n - 1].theoretical || n < timetable.size -1  && lesson.name == timetable[i][n + 1].name && timetable[i][n + 1].theoretical) {
                    result = (result + point).toUShort()
                }

                else if (numberOfSameLessons > 1 && numberOfSameLessonsTheoretical > 0 && numberOfSameLessonsNotTheoretical >0 ){
                    result = (result + point).toUShort()
                }
                else {
                    result = (result - point).toUShort()
                }


            }
        }


        if (result > bestScore) {
            GlobalScope.bestTimetable.clear()
            GlobalScope.bestTimetable[timetable] = result
            counter = (counter + 1u).toUShort()
        }


        return result.toUShort()
    }
    fun getCounter(): UShort{
        return counter
    }
}