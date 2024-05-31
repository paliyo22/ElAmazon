import java.util.ArrayList;

public enum ECountry {
    Argentina{
        private static ArrayList<String> district=new ArrayList<>();
        public void addDistrict(String d){
            this.district.add(d);
        }
        public ArrayList<String> getDistrict(){
            return district;
        }
    },
    Uruguay{
        private static ArrayList<String> district=new ArrayList<>();
        public void addDistrict(String d){
            this.district.add(d);
        }
        public ArrayList<String> getDistrict(){
            return district;
        }
    },
    Brazil{
        private static ArrayList<String> district=new ArrayList<>();
        public void addDistrict(String d){
            this.district.add(d);
        }
        public ArrayList<String> getDistrict(){
            return district;
        }
    };
    abstract void addDistrict(String d);
    abstract ArrayList<String> getDistrict();
    public void fileToEnum(ECountry a, String d){
        switch (a){
            case Argentina -> Argentina.addDistrict(d);
            case Brazil -> Brazil.addDistrict(d);
            case Uruguay -> Uruguay.addDistrict(d);
        }
    }
    /**
     * preguntar si esta bien agregarle campo int a las provincias para hacer las relaciones en tiempo de envio
     */
}
