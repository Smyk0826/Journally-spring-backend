import react, { useContext, useState } from "react";
import Title from "./Title";
import LogOut from "./buttons/logout";
import axios from "axios";
import { idContext } from "../context/context";
import Popup from "./popup";

function Notebook(){
   const date = new Date();
   const userId = useContext(idContext);
   console.log(userId);
   const fullDate = date.toDateString();
   const [noteData, setNoteData] = useState();
   const [popuptrigger, setpopupTrigger] = useState(false);
   const [errMess, seterrMess] = useState('');
   const handleSubmit = async (e) => {
        e.preventDefault();
             axios.post('http://localhost:8080/notes',{
                "data" : noteData,
                "date" :fullDate,
                "userId" : userId.id
            }).then(response => {
                console.log('Status Code:', response.status); // ✅ status code like 200 or 201
                console.log('Response Data:', response.data);
                if(response.status === 200){
                 seterrMess('Submitted successfully');
                setpopupTrigger(true);
            }

            })
            .catch(error => {
                if (error.response) {
                console.log('Error Status:', error.response.status); // e.g. 400, 500
                console.log('Error Message:', error.response.data);
                } else {
                console.log('Network Error or No Response:', error.message);
                }
            });
            
    }
return(
    
    <div>
        <div className="TitleBar">
            <div>
            <Title/>
            </div>
            <div className="buttonBox">
                <LogOut/>
            </div>
        
        </div>
        <div className="TextWriting">
            <h2 className="Gratitude">Hi!, how have you been?</h2>
            <form onSubmit={handleSubmit}>
            <div className="form-group">
                <input type="email" className="form-control" id="exampleFormControlInput1" value={fullDate} readOnly={true} />
            </div>
            <textarea rows="8" cols="60" className="TextArea form-control" placeholder="What's on your mind?" value = {noteData} onChange={(e)=>setNoteData(e.target.value)}/>
            <button className="submit btn btn-dark">Submit</button>
            </form>
            
        </div>
         <Popup trigger={popuptrigger} setTrigger = {setpopupTrigger}>
                <h3>{errMess}</h3>
            </Popup>
    </div>);
}
export default Notebook;