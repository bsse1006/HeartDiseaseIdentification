package ml;

public class DataPoint
{
    private double age;
    private double sex;
    private double cp;
    private double trestbps;
    private double chol;
    private double fbs;
    private double restecg;
    private double thalach;
    private double exang;
    private double oldpeak;
    private double slope;
    private double ca;
    private double thal;
    private double num;

    public DataPoint()
    {

    }

    public DataPoint(double age, double sex, double cp, double trestbps, double chol, double fbs, double restecg, double thalach, double exang, double oldpeak, double slope, double ca, double thal, double num) {
        this.age = age;
        this.sex = sex;
        this.cp = cp;
        this.trestbps = trestbps;
        this.chol = chol;
        this.fbs = fbs;
        this.restecg = restecg;
        this.thalach = thalach;
        this.exang = exang;
        this.oldpeak = oldpeak;
        this.slope = slope;
        this.ca = ca;
        this.thal = thal;
        this.num = num;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setSex(double sex) {
        this.sex = sex;
    }

    public void setCp(double cp) {
        this.cp = cp;
    }

    public void setTrestbps(double trestbps) {
        this.trestbps = trestbps;
    }

    public void setChol(double chol) {
        this.chol = chol;
    }

    public void setFbs(double fbs) {
        this.fbs = fbs;
    }

    public void setRestecg(double restecg) {
        this.restecg = restecg;
    }

    public void setThalach(double thalach) {
        this.thalach = thalach;
    }

    public void setExang(double exang) {
        this.exang = exang;
    }

    public void setOldpeak(double oldpeak) {
        this.oldpeak = oldpeak;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public void setCa(double ca) {
        this.ca = ca;
    }

    public void setThal(double thal) {
        this.thal = thal;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public double getAge() {
        return age;
    }

    public double getSex() {
        return sex;
    }

    public double getCp() {
        return cp;
    }

    public double getTrestbps() {
        return trestbps;
    }

    public double getChol() {
        return chol;
    }

    public double getFbs() {
        return fbs;
    }

    public double getRestecg() {
        return restecg;
    }

    public double getThalach() {
        return thalach;
    }

    public double getExang() {
        return exang;
    }

    public double getOldpeak() {
        return oldpeak;
    }

    public double getSlope() {
        return slope;
    }

    public double getCa() {
        return ca;
    }

    public double getThal() {
        return thal;
    }

    public double getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "DataPoint{" +
                "age=" + age +
                ", sex=" + sex +
                ", cp=" + cp +
                ", trestbps=" + trestbps +
                ", chol=" + chol +
                ", fbs=" + fbs +
                ", restecg=" + restecg +
                ", thalach=" + thalach +
                ", exang=" + exang +
                ", oldpeak=" + oldpeak +
                ", slope=" + slope +
                ", ca=" + ca +
                ", thal=" + thal +
                ", num=" + num +
                '}';
    }
}
