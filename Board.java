// Source code is decompiled from a .class file using FernFlower decompiler.
class Board {
   private char[][] b = new char[3][3];
   private char p1s;
   private char p2s;
   private char em = ' ';

   public Board(char var1, char var2) {
      for(int var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 3; ++var4) {
            this.b[var3][var4] = this.em;
         }
      }

      this.p1s = var1;
      this.p2s = var2;
   }

   void update(int var1, int var2, int var3) {
      if (var3 == 1) {
         this.b[var1][var2] = this.p1s;
      } else {
         this.b[var1][var2] = this.p2s;
      }

   }

   void print() {
      System.out.println("____________________");

      for(int var1 = 0; var1 < 3; ++var1) {
         System.out.print("||");

         for(int var2 = 0; var2 < 3; ++var2) {
            System.out.print("  " + this.b[var1][var2] + "  ||");
         }

         System.out.println();
      }

   }

   int check() {
      char var1 = ' ';

      for(int var2 = 0; var2 < 3; ++var2) {
         if (this.b[var2][0] == this.b[var2][1] && this.b[var2][1] == this.b[var2][2]) {
            var1 = this.b[var2][0];
            break;
         }

         if (this.b[0][var2] == this.b[1][var2] && this.b[1][var2] == this.b[2][var2]) {
            var1 = this.b[0][var2];
            break;
         }
      }

      if (this.b[0][0] == this.b[1][1] && this.b[1][1] == this.b[2][2]) {
         var1 = this.b[1][1];
      }

      if (this.b[0][2] == this.b[1][1] && this.b[1][1] == this.b[2][0]) {
         var1 = this.b[1][1];
      }

      if (var1 == this.p1s) {
         return 1;
      } else {
         return var1 == this.p2s ? 2 : 0;
      }
   }

   boolean isfill(int var1, int var2) {
      return this.b[var1][var2] != ' ';
   }
}
