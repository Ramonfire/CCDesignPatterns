package StructureClasses;

public class Messages {
    private String TypeAlarm;
    private String data;

    public Messages() {
    }

    public String getTypeAlarm() {
        return TypeAlarm;
    }

    public void setTypeAlarm(String typeAlarm) {
        TypeAlarm = typeAlarm;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "TypeAlarm='" + TypeAlarm + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
