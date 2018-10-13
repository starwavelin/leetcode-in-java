/**************
* Problem No. : 49
* Problem Name: Group Anagrams
* Problem URL :
* Date        : Oct 12 2018
* Author      : Xian Lin
***************/

var groupAnagrams = function(strs) {
    let res = [];
    let map = {};
    for (let s of strs) {
        let key = sort(s); // key is sorted s!!
        map[key] = map[key] || [];
        map[key].push(s);
    }
    for (let key in map) {
        res.push(map[key]);
    }
    return res;
};

const sort = function(s) {
    let charArr = s.split('');
    charArr.sort((a, b) => (a < b) ? -1 : 1);
    return charArr.join('');
}
