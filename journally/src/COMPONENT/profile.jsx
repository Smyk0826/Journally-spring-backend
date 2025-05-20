import react, {useContext, useEffect, useState } from "react";
import Title from "./Title";
import ListItem from "./NotesList/NotesItem";
import Note_book from "./buttons/notebook";
import LogOut from "./buttons/logout";
import { useLocation } from "react-router-dom";
import axios from "axios";
import { nameContext } from "../context/context";
import { idContext } from "../context/context";

function Profile_page(){
    const value = useContext(nameContext);
    const userId = useContext(idContext);
    useEffect(() => {
    // Function to fetch data
    const fetchData = async () => {
      try {
       // setLoading(true);
        const response = await axios.get('http://localhost:8080/notes?userId='+userId.id);
        console.log(response);
        //setData(response.data);
      } catch (err) {
        //setError(err.message);
      } 
    };

    fetchData(); // Call the function when the component mounts
  }, []); // Empty dependency array means it runs only once

return(
 
    <div>
        <div className="TitleBar">
            <div>
            <Title/>
            </div>
            <div className="buttonBox">
                <Note_book/> 
                <LogOut/>
            </div>
        
        </div>
            <h2 className = "Greetings">Hi! {value.name}</h2>
            <div className="NoteListContainer">
                <ListItem date = "22 April 2024" title = {value.name}></ListItem>
            </div>
            
    </div>
    );
}

export default Profile_page;