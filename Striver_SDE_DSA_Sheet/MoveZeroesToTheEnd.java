You are given an array of both containing zero and non-zero elements.
Move all zeroes to the end while maintaining the relative order of non-zero elements.
  Example :
      array = {0,1,4,0,2,3,0,0,5,6}
      output : {1,4,2,3,5,6,0,0,0,0}
Bruteforce Approach :
     * Store all the non-zero elements in a temporary array or an arraylist.
     * Now iterate through the array and insert the temp. array elements into the original array
         using an index pointer.
     * Now set back all the remaining elements to zeroes.
