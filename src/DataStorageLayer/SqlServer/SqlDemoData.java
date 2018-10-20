package DataStorageLayer.SqlServer;

public class SqlDemoData {

    //todo; for loop this stuff....


//Write a loop for this below.
//Test this loop
//        String provisionString = "";
//        Random rnd = new Random();
//        for(int i = 0; i < 10; i++){
//            for(int j = 0; j < 10; i++) {
//                int c = rnd.nextInt(100);
//                provisionString += "insert INTO Watched (Percentage, ProfileId, ProgramId) values (" + c + ","+ j + ","+ i + ");";
//            }
//        }


    private SqlDemoData() {
    }


    public static String getAccountDemoData() {
        return "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Edward Porter', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Oliver Spencer' , '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Harrison Hudson', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Josh Cole', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Reuben Ryan', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Amy Stacy', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Amber Jefferson', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Jill Williams', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Alexandra Ness', '14216 Rusk Avenue', 1633, '1633', 'Haixing');" +
                "INSERT INTO Accounts (Name, Street, PostalCode, HouseNumber, Place) values ('Alexis Amazon', '14216 Rusk Avenue', 1633, '1633', 'Haixing');";
    }

    public static String getProfileDemoData() {
        return "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Edward Porter', '09/11/1922', 1);" +
                "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Oliver Spencer', '09/09/1983', 2);" +
                "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Harrison Hudson', '09/02/1973', 3);" +
                "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Josh Cole', '09/03/1963', 4);" +
                "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Reuben Ryan', '09/05/1953', 5);" +
                "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Amy Stacy', '09/06/1943', 6);" +
                "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Amber Jefferson', '08/02/1923', 7);" +
                "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Jill Williams', '09/09/1991', 8);" +
                "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Alexandra Ness', '09/02/1993', 9);" +
                "INSERT INTO Profiles (Name, BirthDate, AccountId) values ('Alexis Amazon', '09/08/1995', 10);";
    }

    public static String getProgramDemoData() {
        return "insert INTO Programs (Title, Duration) values ('Better Call Saul', '22:59');" +
                "insert INTO Programs (Title, Duration) values ('Game of Thrones', '22:59');" +
                "insert INTO Programs (Title, Duration) values ('Stranger Things', '22:59');" +
                "insert INTO Programs (Title, Duration) values ('Sherlock', '22:59');" +
                "insert INTO Programs (Title, Duration) values ('Orange is the New Black', '22:59');" +
                "insert INTO Programs (Title, Duration) values ('Forrest Gump', '02:12');" +
                "insert INTO Programs (Title, Duration) values ('The Godfather', '02:23');" +
                "insert INTO Programs (Title, Duration) values ('Alien: Covenant', '02:35');" +
                "insert INTO Programs (Title, Duration) values ('The Lord of the Rings', '03:00');" +
                "insert INTO Programs (Title, Duration) values ('Saving private ryan', '03:12');" +

                "insert INTO Programs (Title, Duration) values ('Better Call Saul E1', '01:00');" +
                "insert INTO Programs (Title, Duration) values ('Better Call Saul E2', '01:00');" +
                "insert INTO Programs (Title, Duration) values ('Better Call Saul E3', '01:00');" +

                "insert INTO Programs (Title, Duration) values ('Game of Thrones E1', '01:00');" +
                "insert INTO Programs (Title, Duration) values ('Game of Thrones E2', '01:00');" +
                "insert INTO Programs (Title, Duration) values ('Game of Thrones E3', '01:00');" +

                "insert INTO Programs (Title, Duration) values ('Stranger Things E1', '01:00');" +
                "insert INTO Programs (Title, Duration) values ('Stranger Things E2', '01:00');" +
                "insert INTO Programs (Title, Duration) values ('Stranger Things E3', '01:00');" +

                "insert INTO Programs (Title, Duration) values ('Sherlock E1', '01:00');" +
                "insert INTO Programs (Title, Duration) values ('Sherlock E2', '01:00');" +
                "insert INTO Programs (Title, Duration) values ('Sherlock E3', '01:00');" +

                "insert INTO Programs (Title, Duration) values ('Orange is the New Black E1', '01:00');" +
                "insert INTO Programs (Title, Duration) values ('Orange is the New Black E2', '01:00');" +
                "insert INTO Programs (Title, Duration) values ('Orange is the New Black E3', '01:00');";

    }


    public static String getSerieDemoData() {
        return "insert INTO Series (Name, Age, Genre, Language) values ('Better Call Saul', 9, 'Comedy', 'English');" +
                "insert INTO Series (Name, Age, Genre, Language) values ('Game of Thrones', 16, 'Action', 'English');" +
                "insert INTO Series (Name, Age, Genre, Language) values ('Stranger Things', 12, 'Thriller | Action', 'English');" +
                "insert INTO Series (Name, Age, Genre, Language) values ('Sherlock', 9, 'Drama | Action', 'English');" +
                "insert INTO Series (Name, Age, Genre, Language) values ('Orange is the New Black', 12, 'Action | Drama', 'English');";
    }

    public static String getEpisodeDemoData() {
        return "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 1, 11);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 1, 12);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 1, 13);" +


                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 2, 14);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 2, 15);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 2, 16);" +


                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 3, 17);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 3, 18);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 3, 19);" +


                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 4, 20);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 4, 21);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 4, 22);" +


                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 5, 23);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 5, 24);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 5, 25);";
    }


    public static String getMovieDemoData() {
        return "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (12, 'English', 'Drama', 6);" +
                "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (12, 'English', 'Action', 7);" +
                "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (16, 'English', 'Action | Crime', 8);" +
                "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (12, 'English', 'Action | Drama', 9);" +
                "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (12, 'English', 'Action | War', 10);";
    }

    public static String getWatchedDemoData() {
        return  "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 11);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 11);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 11);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 11);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 11);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 11);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 11);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 11);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 11);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 11);" +

                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 14);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 14);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 14);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 14);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 14);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 14);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 14);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 14);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 14);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 14);" +

                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 17);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 17);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 17);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 17);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 17);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 17);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 17);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 17);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 17);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 17);" +

                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 20);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 20);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 20);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 20);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 20);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 20);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 20);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 20);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 20);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 20);" +

                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 23);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 23);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 23);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 23);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 23);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 23);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 23);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 23);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 23);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 23);" +

                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 6);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 6);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 6);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 6);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 6);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 6);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 6);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 6);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 6);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 6);" +

                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 7);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 7);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 7);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 7);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 7);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 7);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7,7);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 7);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 7);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 7);" +

                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 8);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 8);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 8);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 8);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 8);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 8);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 8);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 8);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 8);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 8);" +

                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 9);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 9);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 9);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 9);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 9);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 9);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 9);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 9);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 9);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 9);" +

                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 10);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 10);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 10);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 10);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 10);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 10);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 10);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 10);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 10);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 10);";
    }
}
