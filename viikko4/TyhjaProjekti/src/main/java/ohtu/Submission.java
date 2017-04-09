package ohtu;


public class Submission {

    private String student_number;

    private int week;
    private int points;
    private int countedPoints;
    private int hours;
    private int maxPoints;

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
//        System.out.println("Maxpoints set to "+maxPoints);
    }
 
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int countPoints() {
        countedPoints=0;
         if (isA1()) {
            countedPoints+=1;
        }
        if (isA2()) {
            countedPoints+=1;
        }
        if (isA3()) {
            countedPoints+=1;
        }
        if (isA4()) {
              countedPoints+=1;
        }
        if (isA5()) {
              countedPoints+=1;
        }
        if (isA6()) {
              countedPoints+=1;
        }
        if (isA7()) {
              countedPoints+=1;
        }
        if (isA8()) {
              countedPoints+=1;
        }
        if (isA9()) {
              countedPoints+=1;
        }
        if (isA10()) {
              countedPoints+=1;
        }
        if (isA11()) {
              countedPoints+=1;
        }
        if (isA12()) {
              countedPoints+=1;
        }
        if (isA13()) {
              countedPoints+=1;
        }
        if (isA14()) {
              countedPoints+=1;
        }
        if (isA15()) {
              countedPoints+=1;
        }
        if (isA16()) {
              countedPoints+=1;
        }
        if (isA17()) {
              countedPoints+=1;
        }
        if (isA18()) {
              countedPoints+=1;
        }
        if (isA19()) {
              countedPoints+=1;
        }
        if (isA20()) {
              countedPoints+=1;
        }
        if (isA21()) {
              countedPoints+=1;
        }
        

        return countedPoints;
    }
    
    
    @Override
    public String toString() {
        String viesti;
        if (maxPoints!=0) {
        viesti = "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + countPoints() + " (maksimi "+maxPoints+"), aikaa kului " + hours + " tuntia, tehdyt tehtävät:";
        } else {
        viesti = "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + countPoints() + ", aikaa kului " + hours + " tuntia, tehdyt tehtävät:";

        }    
        if (isA1()) {
            viesti += " 1";
        }
        if (isA2()) {
            viesti += " 2";
        }
        if (isA3()) {
            viesti += " 3";
        }
        if (isA4()) {
            viesti += " 4";
        }
        if (isA5()) {
            viesti += " 5";
        }
        if (isA6()) {
            viesti += " 6";
        }
        if (isA7()) {
            viesti += " 7";
        }
        if (isA8()) {
            viesti += " 8";
        }
        if (isA9()) {
            viesti += " 9";
        }
        if (isA10()) {
            viesti += " 10";
        }
        if (isA11()) {
            viesti += " 11";
        }
        if (isA12()) {
            viesti += " 12";
        }
        if (isA13()) {
            viesti += " 13";
        }
        if (isA14()) {
            viesti += " 14";
        }
        if (isA15()) {
            viesti += " 15";
        }
        if (isA16()) {
            viesti += " 16";
        }
        if (isA17()) {
            viesti += " 17";
        }
        if (isA18()) {
            viesti += " 18";
        }
        if (isA19()) {
            viesti += " 19";
        }
        if (isA20()) {
            viesti += " 20";
        }
        if (isA21()) {
            viesti += " 21";
        }
        

        return viesti;
    }


    /**
     * @return the week
     */
    public int getWeek() {
        return week;
    }

    /**
     * @param week the week to set
     */
    public void setWeek(int week) {
        this.week = week;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        if (points==0)
        return countedPoints;
        else return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.countedPoints = points;
    }

    /**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * @return the a1
     */
    public boolean isA1() {
        return a1;
    }

    /**
     * @param a1 the a1 to set
     */
    public void setA1(boolean a1) {
        this.a1 = a1;
    }

    /**
     * @return the a2
     */
    public boolean isA2() {
        return a2;
    }

    /**
     * @param a2 the a2 to set
     */
    public void setA2(boolean a2) {
        this.a2 = a2;
    }

    /**
     * @return the a3
     */
    public boolean isA3() {
        return a3;
    }

    /**
     * @param a3 the a3 to set
     */
    public void setA3(boolean a3) {
        this.a3 = a3;
    }

    /**
     * @return the a4
     */
    public boolean isA4() {
        return a4;
    }

    /**
     * @param a4 the a4 to set
     */
    public void setA4(boolean a4) {
        this.a4 = a4;
    }

    /**
     * @return the a5
     */
    public boolean isA5() {
        return a5;
    }

    /**
     * @param a5 the a5 to set
     */
    public void setA5(boolean a5) {
        this.a5 = a5;
    }

    /**
     * @return the a6
     */
    public boolean isA6() {
        return a6;
    }

    /**
     * @param a6 the a6 to set
     */
    public void setA6(boolean a6) {
        this.a6 = a6;
    }

    /**
     * @return the a7
     */
    public boolean isA7() {
        return a7;
    }

    /**
     * @param a7 the a7 to set
     */
    public void setA7(boolean a7) {
        this.a7 = a7;
    }

    /**
     * @return the a8
     */
    public boolean isA8() {
        return a8;
    }

    /**
     * @param a8 the a8 to set
     */
    public void setA8(boolean a8) {
        this.a8 = a8;
    }

    /**
     * @return the a9
     */
    public boolean isA9() {
        return a9;
    }

    /**
     * @param a9 the a9 to set
     */
    public void setA9(boolean a9) {
        this.a9 = a9;
    }

    /**
     * @return the a10
     */
    public boolean isA10() {
        return a10;
    }

    /**
     * @param a10 the a10 to set
     */
    public void setA10(boolean a10) {
        this.a10 = a10;
    }

    /**
     * @return the a11
     */
    public boolean isA11() {
        return a11;
    }

    /**
     * @param a11 the a11 to set
     */
    public void setA11(boolean a11) {
        this.a11 = a11;
    }

    /**
     * @return the a12
     */
    public boolean isA12() {
        return a12;
    }

    /**
     * @param a12 the a12 to set
     */
    public void setA12(boolean a12) {
        this.a12 = a12;
    }

    /**
     * @return the a13
     */
    public boolean isA13() {
        return a13;
    }

    /**
     * @param a13 the a13 to set
     */
    public void setA13(boolean a13) {
        this.a13 = a13;
    }

    /**
     * @return the a14
     */
    public boolean isA14() {
        return a14;
    }

    /**
     * @param a14 the a14 to set
     */
    public void setA14(boolean a14) {
        this.a14 = a14;
    }

    /**
     * @return the a15
     */
    public boolean isA15() {
        return a15;
    }

    /**
     * @param a15 the a15 to set
     */
    public void setA15(boolean a15) {
        this.a15 = a15;
    }

    /**
     * @return the a16
     */
    public boolean isA16() {
        return a16;
    }

    /**
     * @param a16 the a16 to set
     */
    public void setA16(boolean a16) {
        this.a16 = a16;
    }

    /**
     * @return the a17
     */
    public boolean isA17() {
        return a17;
    }

    /**
     * @param a17 the a17 to set
     */
    public void setA17(boolean a17) {
        this.a17 = a17;
    }

    /**
     * @return the a18
     */
    public boolean isA18() {
        return a18;
    }

    /**
     * @param a18 the a18 to set
     */
    public void setA18(boolean a18) {
        this.a18 = a18;
    }

    /**
     * @return the a19
     */
    public boolean isA19() {
        return a19;
    }

    /**
     * @param a19 the a19 to set
     */
    public void setA19(boolean a19) {
        this.a19 = a19;
    }

    /**
     * @return the a20
     */
    public boolean isA20() {
        return a20;
    }

    /**
     * @param a20 the a20 to set
     */
    public void setA20(boolean a20) {
        this.a20 = a20;
    }

    /**
     * @return the a21
     */
    public boolean isA21() {
        return a21;
    }

    /**
     * @param a21 the a21 to set
     */
    public void setA21(boolean a21) {
        this.a21 = a21;
    }

}
