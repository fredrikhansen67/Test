/**
 * Created by pappa on 2018-10-27.
 */
public class ViewSwitch {
    private ViewSwitch(){}

    private String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
        String typeOfDay;
        switch (dayOfWeekArg) {
            case "Monday":
                typeOfDay = "Just another manic Monday, wish it was Sunday";
                break;
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                typeOfDay = "Midweek";
                break;
            case "Friday":
                typeOfDay = "End of work week";
                break;
            case "Saturday":
            case "Sunday":
                typeOfDay = "Weekend";
                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
        }
        return typeOfDay;
    }

    private String getTypeOfConnectionWithSwitchStatement(String connection){
        String con;
        switch (connection.toUpperCase()){
            case "HTTP":
                con="HTTP";
                break;
            case "HTTPS":
                con = "HTTPS";
                break;
            case "SSL":
                con = "SSL";
                break;
            default:
                throw new IllegalArgumentException("Invalid connection type: " + connection);

        }
        return con;
    }



    public static void main(String[] args) {
        ViewSwitch vs = new ViewSwitch();
        String[] str = {"Monday", "Tuesday", "Sunday", "Friday", "Thursday", "Saturday"};
        String[] str1 = {"SSL","HTTP","https"};
        for(String ss:str){
            System.out.println(vs.getTypeOfDayWithSwitchStatement(ss));

        }
        for(String ss:str1){
            System.out.println(vs.getTypeOfConnectionWithSwitchStatement(ss));

        }

    }
}
