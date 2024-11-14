public abstract class Gatherable {

    protected int quantity;
    protected Quality quality;
    public enum Quality
    {
        COMMON,
        RARE,
        EPIC
    }

    public Gatherable(int quantity,Quality quality )
    {
        this.quality=quality;
        this.quantity=quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public Quality getQuality()
    {
        return quality;
    }

    public void setQuality(Quality quality)
    {
        this.quality = quality;
    }

    public abstract void gather();

    @Override
    public abstract String toString();

}
