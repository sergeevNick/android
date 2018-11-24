package ru.sergeev.gettingstarted.environment;

public class Environment {
    public static String baseUrl = "http://192.168.0.104:8080";

    public static class Mark {
        private static String base = "/marks";

        public static String all = Mark.base;
        public static String mark = Mark.base + "/:markId";
        public static String byStudentAndSubject = Mark.base + "/students/:studentId/subjects/:subjectId";

    }

    public static class Schedule {
        private static String base = "/schedules";

        public static String all = Schedule.base;
        public static String byGrade = Schedule.base + "/grades/:gradeId";

    }


    private Environment() {
    }
}
