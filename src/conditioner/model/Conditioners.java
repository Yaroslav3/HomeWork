package conditioner.model;

public class Conditioners<S> {
    private String OnOff;
    private String name;
    private int temp;

    public Conditioners(String onOff, String name) {
        OnOff = onOff;
        this.name = name;
    }

    public int getTemp() {
        return temp;
    }

    public int setTemp(int temp) {
        this.temp = temp;
        return temp;
    }

    public String getOnOff() {
        return OnOff;
    }

    public String setOnOff(String onOff) {
        OnOff = onOff;
        return OnOff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return OnOff + " " + name;
    }
}
