function is_email(email){
	// a very simple email validation checking.
	// you can add more complex email checking if it helps
    var splitted = email.match("^(.+)@(.+)$");
    if(splitted == null) return false;
    if(splitted[1] != null )
    {
      var regexp_user=/^\"?[\w-_\.]*\"?$/;
      if(splitted[1].match(regexp_user) == null) 
      	return false;
    }
    if(splitted[2] != null)
    {
      var regexp_domain=/^[\w-\.]*\.[A-Za-z]{2,4}$/;
      if(splitted[2].match(regexp_domain) == null) 
      {
	    var regexp_ip =/^\[\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\]$/;
	    if(splitted[2].match(regexp_ip) == null) 
	    	return false;
      }// if
      return true;
    }
	return false;
}



String.prototype.rTrim= function(){
    var whitespace = new String(" \t\n\r");
    var s = new String(this);
    if (whitespace.indexOf(s.charAt(s.length-1)) != -1){
        var i = s.length - 1;
        while (i >= 0 && whitespace.indexOf(s.charAt(i)) != -1){
            i--;
        }
        s = s.substring(0, i+1);
    }
    return s;
}

String.prototype.lTrim= function(){
    var whitespace = new String(" \t\n\r");
    var s = new String(this);
    if (whitespace.indexOf(s.charAt(0)) != -1){
        var j=0, i = s.length;
        while (j < i && whitespace.indexOf(s.charAt(j)) != -1){
            j++;
        }
        s = s.substring(j, i);
    }
    return s;
}

//数组集合操作。
Array.prototype.contains = function (elem) {
   for (var i = 0; i < this.length; i++) {
            if (this[i] == elem) {
                    return true;
            }
      }
     return false;
}

Array.prototype.indexOf = function(o){   
    for(var i = 0 ;  i<this.length;i++){
           if(this[i] == o){
                return i;
           }
    }
    return -1;
}

Array.prototype.removeIndexOf = function(index){
	  return this.splice(index,1);
}

Array.prototype.remove = function(o){
	  var index = this.indexOf(o);
	  if(index != -1){
	         this.splice(index,1);
	  }
	  return this;
}

Array.prototype.removeAll = function (array) {
	   for (var i = 0; i < array.length; i++) {
	        this.remove(array[i]);
	   }
	   return this;
}

/**
 * each是一个集合迭代函数，它接受一个函数作为参数和一组可选的参数 这个迭代函数依次将集合的每一个元素和可选参数用函数进行计算，并将计算得的结果集返回
 * {%example <script> var a = [1,2,3,4].each(function(x){return x > 2 ? x :
 * null}); var b = [1,2,3,4].each(function(x){return x < 0 ? x : null});
 * alert(a); alert(b); </script> %}
 * 
 * @param {Function}
 *            fn 进行迭代判定的函数
 * @param more
 *            ... 零个或多个可选的用户自定义参数
 * @returns {Array} 结果集，如果没有结果，返回空集
 */
Array.prototype.each = function(fn){
    fn = fn || Function.K;
     var a = [];
     var args = Array.prototype.slice.call(arguments, 1);
     for(var i = 0; i < this.length; i++){
         var res = fn.apply(this,[this[i],i].concat(args));
         if(res != null) a.push(res);
     }
     return a;
};
/**
 * 得到一个数组不重复的元素集合<br/> 唯一化一个数组
 * 
 * @returns {Array} 由不重复元素构成的数组
 */
Array.prototype.unique = function(){
     var ra = new Array();
     for(var i = 0; i < this.length; i ++){
         if(!ra.contains(this[i])){
            ra.push(this[i]);
         }
     }
     return ra;
};
/**
 * 求两个集合的补集 {%example <script> var a = [1,2,3,4]; var b = [3,4,5,6];
 * alert(Array.complement(a,b)); </script> %}
 * 
 * @param {Array}
 *            a 集合A
 * @param {Array}
 *            b 集合B
 * @returns {Array} 两个集合的补集
 */
Array.complement = function(a, b){
     return Array.minus(Array.union(a, b),Array.intersect(a, b));
};
/**
 * 求两个集合的交集 {%example <script> var a = [1,2,3,4]; var b = [3,4,5,6];
 * alert(Array.intersect(a,b)); </script> %}
 * 
 * @param {Array}
 *            a 集合A
 * @param {Array}
 *            b 集合B
 * @returns {Array} 两个集合的交集
 */
Array.intersect = function(a, b){
     return a.unique().each(function(o){return b.contains(o) ? o : null});
};
/**
 * 求两个集合的差集 {%example <script> var a = [1,2,3,4]; var b = [3,4,5,6];
 * alert(Array.minus(a,b)); </script> %}
 * 
 * @param {Array}
 *            a 集合A
 * @param {Array}
 *            b 集合B
 * @returns {Array} 两个集合的差集
 */
Array.minus = function(a, b){
     return a.unique().each(function(o){return b.contains(o) ? null : o});
};
/**
 * 求两个集合的并集 {%example <script> var a = [1,2,3,4]; var b = [3,4,5,6];
 * alert(Array.union(a,b)); </script> %}
 * 
 * @param {Array}
 *            a 集合A
 * @param {Array}
 *            b 集合B
 * @returns {Array} 两个集合的并集
 */
Array.union = function(a, b){
     return a.concat(b).unique();
};
