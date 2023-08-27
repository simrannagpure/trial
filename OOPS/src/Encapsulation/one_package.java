package Encapsulation;

class one_package {
    public static void main(String[] args) {
        parent_class parent = new parent_class();
        System.out.println(parent.def_prop);
        System.out.println(parent.public_prop);
        System.out.println(parent.protected_prop);
      //  System.out.println(parent.private_pro); not accesible
        System.out.println(parent.getPrivate_pro());


    }
    static class parent_class{
        String def_prop = "default variable";
        public String public_prop = "public variable";
        private String private_pro = "private variable";
        protected String protected_prop = "protected variable";

        //methods
         public static int sum(int a, int b){
            return a+b;
        }
        //getters
        public String getPrivate_pro(){
            return this.private_pro;
        }
    }
    class sub_class{
    }
}

