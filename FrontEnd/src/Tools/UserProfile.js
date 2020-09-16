var UserProfile = (function() {
    var full_name = "";
    var userID = ""
  
    var getName = function() {
      return full_name;    // Or pull this from cookie/localStorage
    };
  
    var setName = function(name) {
      full_name = name;     
      // Also set this in cookie/localStorage
    };

    var getID = function() {
      return userID;    // Or pull this from cookie/localStorage
    };

    var setID = function(id) {
      userID = id;     
      // Also set this in cookie/localStorage
    };

    var logout = function() {
      setName("")
      setID("")
    }
  
    return {
      getName: getName,
      setName: setName,
      getID: getID,
      setID: setID 
    }
  
  })();
  
  // export default UserProfile;