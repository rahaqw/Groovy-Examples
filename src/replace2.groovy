#!/usr/bin/env groovy

println "\$foo\$foo".replaceAll(/\$/, "") 
assert "new-york" == "New York".replace("\\s","")
