// this is all messed up.
def params = [person:["id":"null"], 
  student:["id":"null"], 
  remarks:null
]

println params

def newParams = params.clone()

assert newParams['remarks'] != null  
newParams.remove(newParmas.findAll {
    it.value == null
})
  
assert newParams['remarks'] == null  
