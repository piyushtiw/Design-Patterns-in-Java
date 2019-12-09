abstract class Computer1 {

    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    @Override
    public String toString(){
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
}

class PC1 extends Computer1 {

    private String ram;
    private String hdd;
    private String cpu;

    public PC1(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

}

class Server1 extends Computer1 {

    private String ram;
    private String hdd;
    private String cpu;

    public Server1(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

}

interface ComputerAbstractFactory {

    public Computer1 createComputer();

}

class PCFactory implements ComputerAbstractFactory {

    private String ram;
    private String hdd;
    private String cpu;

    public PCFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public Computer1 createComputer() {
        return new PC1(ram,hdd,cpu);
    }

}

class ServerFactory implements ComputerAbstractFactory {

    private String ram;
    private String hdd;
    private String cpu;

    public ServerFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }

    @Override
    public Computer1 createComputer() {
        return new Server1(ram,hdd,cpu);
    }

}

class ComputerFactory1 {

    public static Computer1 getComputer(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}

class AbstractFactoryPatterns {

    public static void main(String[] args) {
        testAbstractFactory();
    }

    private static void testAbstractFactory() {
        Computer1 pc = ComputerFactory1.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
        Computer1 server = ComputerFactory1.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
        System.out.println("AbstractFactory PC Config::"+pc);
        System.out.println("AbstractFactory Server Config::"+server);
    }
}