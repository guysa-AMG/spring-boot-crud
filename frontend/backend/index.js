let express = require("express")
let cors = require("cors")
let app = express()

app.use(cors(
   {
    origin:["http://localhost:4200"],
  
   } 
))
app.use(express.json())

app.get("/",(req,res)=>{
    console.log("new get request")
     res.send("VELLLLLLLLAXXX");
})

app.post("/reg",(req,res)=>{
    console.log("new post request")
    console.log(req.body)
    res.status(200).send()
})


app.listen(port=1998)