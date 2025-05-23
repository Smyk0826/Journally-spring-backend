import react, {useContext, useEffect, useState } from "react";
import Title from "./Title";
import ListItem from "./NotesList/NotesItem";
import Note_book from "./buttons/notebook";
import LogOut from "./buttons/logout";
import axios from "axios";
import { nameContext } from "../context/context";
import { idContext } from "../context/context";
import { Link } from "react-router-dom";

function Profile_page(){
    const value = useContext(nameContext);
    const userId = useContext(idContext);
    const [notes, setNote] = useState([]);
    useEffect(() => {
    // Function to fetch data
    const fetchData = async () => {
      try {
       // setLoading(true);
        const response = await axios.get('http://localhost:8080/notes?userId='+userId.id);
        console.log(response.data);
        setNote(response.data);
        console.log('notes is : ', notes);
      } catch (err) {
        //setError(err.message);
      } 
    };

    fetchData(); // Call the function when the component mounts
  }, [userId]); // Empty dependency array means it runs only once

return(
 
    <div>
        <div className="TitleBar">
            <div>
            <Title/>
            </div>
            <div className="buttonBox">
                 <Link to="/notebook"> <Note_book/> </Link>
                <LogOut/>
            </div>
        
        </div>
            <h2 className = "Greetings">Hi! {value.name}</h2>
            {notes.map((note,index)=>(
              <div className="NoteListContainer">
                <ListItem date = {note.date.substring(0, 10)} title ={note.data.length > 25 ? note.data.substring(0,25)+'...':note.data}></ListItem>
              </div>
            ))
          }
            
    </div>
    );
}

export default Profile_page;