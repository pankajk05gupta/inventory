import React, {useState, useEffect} from 'react'
import axios from "axios";

function Items() {
const [items, setItems] = useState([])


 useEffect(() => {
     getItems()
    }, [])


    const getItems = () => {
            axios.get("http://localhost:8080/items").then((response) => {
                setItems(response.data)
                console.log(response.data);
            });
        };
        return (
                <div className = "container">

                    <h1 className = "text-center"> Available Inventory  </h1>

                    <table className = "table table-striped">
                        <thead>
                            <tr>
                                <th> Brand </th>
                                <th> Size</th>
                                <th> Quantity</th>
                                <th> Price</th>
                                <th> In Stock</th>
                            </tr>

                        </thead>
                        <tbody>
                            {
                                items.map(
                                        item =>
                                        <tr key = {item.id}>
                                            <td> {item.brand }</td>
                                            <td> {item.size }</td>
                                            <td> {item.quantity }</td>
                                            <td> {item.price }</td>
                                            <td> {item.inStock}</td>
                                        </tr>

                                )
                            }

                        </tbody>


                    </table>

                </div>
            )
        }

     export default Items