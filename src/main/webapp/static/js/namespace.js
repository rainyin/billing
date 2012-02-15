registerNamespace = function(nsName) {
    var rootObject = window;
    var namespaceParts = nsName.split('.');
    for (var i = 0;i < namespaceParts.length; i++) {
        var currentPart = namespaceParts[i];
        if (!rootObject[currentPart]) {
            rootObject[currentPart] = new Object();
        }
        rootObject = rootObject[currentPart];
    }
}