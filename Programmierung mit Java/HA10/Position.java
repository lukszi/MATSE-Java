public class Position
{
    private int x;
    private int y;

    public Position(int x, int y){
        this.y = y;
        this.x = x;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof  Position){
            return this.equals((Position)obj);
        }
        return super.equals(obj);
    }

    public boolean equals(Position p){
        return (this.y == p.y)&&(this.x == p.x);
    }

    public boolean isValid(){
        return (y>0&&x>0)&&(y<9&&x<9);
    }

    @Override
    public String toString(){
        return String.format("(%d,%d)",x,y);
    }
}
