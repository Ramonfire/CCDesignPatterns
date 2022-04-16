package StructureClasses;

public class Messages {
    private String TypeAlarm;
    private Byte[] data;

    public Messages() {
    }

    public String getTypeAlarm() {
        return TypeAlarm;
    }

    public void setTypeAlarm(String typeAlarm) {
        TypeAlarm = typeAlarm;
    }

    public Byte[] getData() {
        return data;
    }

    public void setData(Byte[] data) {
        this.data = data;
    }
}
