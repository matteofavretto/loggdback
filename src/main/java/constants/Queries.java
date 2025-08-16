package constants;

public class Queries {

    public static final String CREATE_EMPTY_LIST = "INSERT INTO lists(list_name, description, tms_added, tms_last_edit) VALUES(?, ?, current_timestamp, current_timestamp)";
}
