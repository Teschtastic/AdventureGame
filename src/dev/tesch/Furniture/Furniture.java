package dev.tesch.Furniture;

public class Furniture {

    public Furniture(String n, String d, String uMessage, boolean cUse) {
        setName(n);
        setDescription(d);
        setUseMessage(uMessage);
        setCanUse(cUse);
    }

    private String name;
    private String description;
    private String useMessage;
    private boolean canUse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUseMessage() {
        return useMessage;
    }

    public void setUseMessage(String useMessage) {
        this.useMessage = useMessage;
    }

    public boolean isCanUse() {
        return canUse;
    }

    public void setCanUse(boolean canUse) {
        this.canUse = canUse;
    }
}
