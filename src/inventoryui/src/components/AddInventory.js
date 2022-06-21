import { useState } from "react";
import axios from "axios";
function AddInventory() {
  const [inputs, setInputs] = useState({});
const [inputs1, setInputs1] = useState("");
const [inputs2, setInputs2] = useState("");
const [inputs3, setInputs3] = useState("");
const [inputs4, setInputs4] = useState("");

  const handleChange = (event) => {
    const name = event.target.name;
    const value = event.target.value;
    setInputs(values => ({...values, [name]: value}))
  }



  const  submitForm = (event) => {
    event.preventDefault();
    console.log(inputs);
    axios.post("http://localhost:8080/item/add",inputs).then((response)=>{
    console.log(response.data);
    })
    window.location.reload(false);
  }

  return (
    <form>
     <center>
     <h1>Add Inventory</h1>
      <label>Brand:
           <input
             type="text"
             name="brand"
             value={inputs.brand || ""}
             onChange={handleChange}
           /></label>
           <br/>
           <label>Size:
             <input
               type="number"
               name="size"
               value={inputs.size || ""}
               onChange={handleChange}
             />
             </label>
             <br/>
             <label>Quantity:
                          <input
                            type="number"
                            name="quantity"
                            value={inputs.quantity || ""}
                            onChange={handleChange}
                          />
                          </label>
                          <br/>
           <label>Price:
                        <input
                          type="number"
                          name="price"
                          value={inputs.price || ""}
                          onChange={handleChange}
                        />
                        </label>
                        <br/>
                        <label>In Stock
                        <select name='inStock' onChange={handleChange} >
                                            <option value={false}>No</option>
                                            <option value={true}>Yes</option>
                         </select>
                         </label>
                         <br/>
             <input type="button" onClick={submitForm} value="Add Item" />
     </center>

    </form>
  )
}

export default AddInventory;
