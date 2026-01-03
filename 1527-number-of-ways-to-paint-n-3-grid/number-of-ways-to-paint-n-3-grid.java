// so 1st clue is hat its countng based problem
        // and alos i see its choices and decisions so its DP
        // befre all lets see hoe each row is painted
        // 1st cell has 3 choices
        // 2nd has 2 except cell1
        // 3rd has 2 except cell2
        // that is 3 * 2 * 2 = 12
        // that mean a single row can be painted 12 different ways
        // but we can also represent that 12 as 2 main groups
        // ABA - mean 1st amd last has same color (exactly 6- ways possible)
        // ABC - all 3 different colos (exactly 6 - ways possible)
       
        // if i pick ABA (ryr) to be the 1st then next row can be 3 aba (yry)(ygy)(grg)
        // and next ABC patter 2 ways (yrg)(gry) because up we already have ryr

        // what if 1st row is ABC (ryg) then
        // next we have 2 ABA (ygy)(grg)
        // next we have 2 abc (ygr)(gry)


        // so mathematicall
        // let ai be the no of ways of ABA patter at row i
        // let bi be the no of ways of ABC pattern at row i

        // a i+1 = 3 * ai + 2 bi
        // b i+1 = 2 * ai + 2 bi
            // Base case (i = 1):
                // a1 = 6, b1 = 6

class Solution {
    public int numOfWays(int n) {
     long aba = 6;
     long abc = 6;
     long mod = 1_000_000_007;   
     for(int i = 1;i <n;i++){
        long nextaba = (3 * aba + 2 * abc) % mod;
        long nextabc = (2 * aba + 2 * abc) % mod;
        aba = nextaba;
        abc = nextabc;
     }
     // if i is already 1 no need to calculate
        return (int) ((aba + abc) % mod);
    }
}