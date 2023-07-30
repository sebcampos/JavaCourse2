public abstract class Shape {

    protected String name;
    protected String textDescription;

    abstract protected double area();

    protected String getDescription() {return getName() + ": " + textDescription;}
    protected String getName() {return name;}

    @Override
    public String toString()
    {
        return name;
    }

    protected void setDescription(String description)
    {
        textDescription = description;
    }

    protected void setName(String name)
    {
        this.name = name;
    }



    // TODO replace this with perimiter methods
    public static double calculateHypotenuse(int width, int height)
    {
        return Math.sqrt(width * width + height * height);
    }
}


