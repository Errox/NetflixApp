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
                "insert INTO Programs (Title, Duration) values ('Saving private ryan', '03:12');";
    }


    public static String getSerieDemoData() {
        return "insert INTO Series (Name, Age, Genre, Language) values ('Better Call Saul', 9, 'Comedy', 'English');" +
                "insert INTO Series (Name, Age, Genre, Language) values ('Game of Thrones', 16, 'Action', 'English');" +
                "insert INTO Series (Name, Age, Genre, Language) values ('Stranger Things', 12, 'Thriller | Action', 'English');" +
                "insert INTO Series (Name, Age, Genre, Language) values ('Sherlock', 9, 'Drama | Action', 'English');" +
                "insert INTO Series (Name, Age, Genre, Language) values ('Orange is the New Black', 12, 'Action | Drama', 'English');";
    }

    public static String getEpisodeDemoData() {
        return "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 1, 1);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 1, 1);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 1, 1);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (4, 1, 1, 1);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (5, 1, 1, 1);" +

                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 2, 2);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 2, 2);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 2, 2);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (4, 1, 2, 2);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (5, 1, 2, 2);" +

                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 3, 3);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 3, 3);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 3, 3);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (4, 1, 3, 3);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (5, 1, 3, 3);" +

                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 4, 4);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 4, 4);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 4, 4);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (4, 1, 4, 4);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (5, 1, 4, 4);" +

                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (1, 1, 5, 5);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (2, 1, 5, 5);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (3, 1, 5, 5);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (4, 1, 5, 5);" +
                "insert INTO Episodes (EpisodeNr, SeasonNr, SerieId, ProgramId) values (5, 1, 5, 5);";
    }


    public static String getMovieDemoData() {
        return "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (12, 'English', 'Drama', 6);" +
                "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (12, 'English', 'Action', 7);" +
                "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (16, 'English', 'Action | Crime', 8);" +
                "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (12, 'English', 'Action | Drama', 9);" +
                "insert INTO Movies (AgeIndication, Language, Genre, ProgramId) values (12, 'English', 'Action | War', 10);";
    }

    public static String getWatchedDemoData(){
        return     "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 1);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 1);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 1);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 1);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 1);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 1);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 1);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 1);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 1);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 1);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 2);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 2);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 2);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 2);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 2);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 2);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 2);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 2);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 2);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 2);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 3);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 3);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 3);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 3);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 3);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 3);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 3);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 3);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 3);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 3);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 4);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 4);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 4);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 4);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 4);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 4);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 4);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 4);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 4);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 4);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 5);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 5);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (35, 3, 5);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (28, 4, 5);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (39, 5, 5);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (99, 6, 5);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (100, 7, 5);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (12, 8, 5);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (30, 9, 5);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (42, 10, 5);" +
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
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (13, 1, 6);" +
                "insert INTO Watched (Percentage, ProfileId, ProgramId) values (22, 2, 6);" +
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
