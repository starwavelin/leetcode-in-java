/**************
* Problem No. : 242
* Problem Name: Valid Anagram
* Problem URL :
* Date        : Oct 11 2018
* Author      : Xian Lin
***************/

var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }

    let arrayMap = new Array(26).fill(0);

    for (let i = 0; i < s.length; i++) {
        arrayMap[s.charAt(i).charCodeAt(0) - 'a'.charCodeAt(0)] += 1;  // In JS, 'a' - 'a' = NaN !!! Keng Die!!!
    }
    for (let i = 0; i < t.length; i++) {
        arrayMap[t.charAt(i).charCodeAt(0) - 'a'.charCodeAt(0)] -= 1;
        if (arrayMap[t.charAt(i).charCodeAt(0) - 'a'.charCodeAt(0)] < 0) {
            return false;
        }
    }

    return true;
};
