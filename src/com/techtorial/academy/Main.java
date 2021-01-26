package com.techtorial.academy;

interface Printable {
    void printPages();

    void printPages(boolean isReverse);

    void printPages(int startPage, int endPage);

    void printPages(int startPage, int endPage, boolean isReverse);
}

abstract class Printer implements Printable {
    private int printSpeed;

    protected Printer(int printSpeed) {
        this.printSpeed = printSpeed;
    }

    @Override
    public void printPages() {
        this.printPages(false);
    }

    @Override
    public void printPages(boolean isReverse) {
        StringBuilder output = new StringBuilder();
        String printOrder = isReverse ? "reverse" : "original";

        output.append("Printing all pages in ")
                .append(printOrder)
                .append(" order ")
                .append(this.printSpeed)
                .append(" pph");

        System.out.println(output);
    }

    @Override
    public void printPages(int startPage, int endPage) {
        this.printPages(startPage, endPage, false);
    }

    @Override
    public void printPages(int startPage, int endPage, boolean isReverse) {
        StringBuilder output = new StringBuilder();
        String printOrder = isReverse ? "reverse" : "original";

        output.append("Printing pages ")
                .append(startPage)
                .append("-")
                .append(endPage)
                .append(" in ")
                .append(printOrder)
                .append(" order ")
                .append(this.printSpeed)
                .append(" pph");

        System.out.println(output);
    }
}

class InkjetPrinter extends Printer {

    public static final int PRINT_SPEED = 20;

    public InkjetPrinter() {
        super(PRINT_SPEED);
    }
}

class LasterPrinter extends Printer {

    public static final int PRINT_SPEED = 60;

    public LasterPrinter() {
        super(PRINT_SPEED);
    }
}

public class Main {
    public static void main(String[] args) {
        Printable inkjetPrinter = new InkjetPrinter();
        Printable laserPrinter = new LasterPrinter();

        usePrinter(inkjetPrinter);
        System.out.println();
        usePrinter(laserPrinter);
    }

    public static void usePrinter(Printable printer) {
        printer.printPages();
        printer.printPages(true);
        printer.printPages(1, 6);
        printer.printPages(2, 9, true);
    }
}
