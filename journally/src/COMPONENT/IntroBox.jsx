import React from "react";
import logo from "../typerwiter.png";
function IntroBox(){
    return(
        <div>
            <div className="IntroBox">
                <p className="IntroPara">Welcome to Journaly — your personal space to capture thoughts, feelings, and memories. 
                Let each page be a quiet escape, where your words flow freely like petals in the breeze.
                 Whether it's a whisper of joy or a storm of emotions, your story finds its home here.</p>
                <img className="IntroImage" src={logo} alt={logo} />
            </div>

        </div>

    )
}
export default IntroBox;