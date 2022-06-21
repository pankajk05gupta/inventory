import MaterialTable from "material-table";
import react from 'react'
import axios from "axios";
const InvTable=()=>{

axios.get("http://localhost:8080/items")
.then(response => {
console.log(response.data);
 });

const columns=[
{title:"Brand",field:"brand"},
{title:"Size",field:"size"}
]
}


export default InvTable;
