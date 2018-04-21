package boxtest;

public class Box {
    private String name;
    private String eqgroup;
    private String remark;
    
    public static void main(String[] args) {
        Box b = new Box();
        String bs = b.toString();
        System.out.println(bs);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEqgroup() {
        return eqgroup;
    }

    public void setEqgroup(String eqgroup) {
        this.eqgroup = eqgroup;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "{name:" + name + ", eqgroup:" + eqgroup + ", remark:" + remark + "}";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((eqgroup == null) ? 0 : eqgroup.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((remark == null) ? 0 : remark.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Box other = (Box) obj;
        if (eqgroup == null) {
            if (other.eqgroup != null)
                return false;
        } else if (!eqgroup.equals(other.eqgroup))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (remark == null) {
            if (other.remark != null)
                return false;
        } else if (!remark.equals(other.remark))
            return false;
        return true;
    }
}
