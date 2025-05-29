console.log("Welcome to Community Portal");
window.onload=()=>{
    alert("Page fully loaded!");
    fetchEvents();
};

class Event
{
    constructor(id,name,date,seats,category){
    this.id=id;
    this.name=name;
    this.date=date;
    this.seats=seats;
    this.category=category;
    }

    checkAvailability()
    {
    return this.seats>0&&new Date(this.date)>new Date();
    }
}

const registrationTracker=(()=>
    {
    let totalRegistrations={};
    return{
    addRegistration(category)
    {
        totalRegistrations[category]=(totalRegistrations[category]||0)+1;
        console.log(`Total ${category} registrations: ${totalRegistrations[category]}`);
    },
    removeRegistration(category)
    {
        if(totalRegistrations[category])
        {
        totalRegistrations[category]--;
        console.log(`Total ${category} registrations: ${totalRegistrations[category]}`);
        }
    }
    };
})();
let events=[];
const addEvent=({id,name,date,seats,category})=>{
    const newEvent=new Event(id,name,date,seats,category);
    events.push(newEvent);
    return newEvent;
};
const registerUser=(eventId,userName,userEmail)=>{
    try{
    if(!userName||!userEmail)throw new Error("Name and email required");
    const event=events.find(e=>e.id===parseInt(eventId));
    if(!event)throw new Error("Event not found");
    if(!event.checkAvailability())throw new Error("Event full or past");
    event.seats--;
    registrationTracker.addRegistration(event.category);
    postRegistration({userName,userEmail,eventId});
    return `Registered ${userName} for ${event.name}`;
    }catch(error){
    throw new Error(`Registration failed: ${error.message}`);
    }
};

const cancelRegistration=(eventId,userName)=>{
    try{
    const event=events.find(e=>e.id===parseInt(eventId));
    if(!event)throw new Error("Event not found");
    event.seats++;
    registrationTracker.removeRegistration(event.category);
    return `Cancelled registration for ${userName} in ${event.name}`;
    }
    catch(error)
    {
    throw new Error(`Cancellation failed: ${error.message}`);
    }
};

const filterEventsByCategory=(category,callback=displayEvents)=>{
    const filtered=category==="All"?[...events]:events.filter(e=>e.category===category);
    callback(filtered);
};

async function fetchEvents(){
    $("#loading").show();
    try{
    const response=await fetch("https://api.mocki.app/v2/sample/events");
    const data=await response.json();
    events=[];
    data.forEach(event=>addEvent(event));
    displayEvents(events);
    }
    catch(error)
    {
    console.error("Fetch error:",error);
    $("#formMessage").text("Failed to load events.").css("color","red");
    }
    finally
    {
    $("#loading").fadeOut();
    }
}

function displayEvents(eventList){
    eventListDiv=document.querySelector("#eventList");
    eventListDiv.innerHTML="";
    eventList.forEach(({id,name,date,seats,category})=>
        {
    if(new Date(date)>new Date()&&seats>0){
        const card=document.createElement("div");
        card.className="event-card";
        card.innerHTML=`
        <h3>${name}</h3>
        <p>Date: ${date}</p>
        <p>Seats: ${seats}</p>
        <p>Category: ${category}</p>
        <button class="register-btn" data-id="${id}">Register</button>
        `;
        eventListDiv.appendChild(card);
        $(card).fadeIn();
    }
    });
    $(".register-btn").click(function()
    {
    const eventId=$(this).data("id");
    const userName=$("#userName").val();
    const userEmail=$("#userEmail").val();
    try
    {
        const message=registerUser(eventId,userName,userEmail);
        $("#formMessage").text(message).css("color","green");
        displayEvents(events);
    }
    catch(error){
        $("#formMessage").text(error.message).css("color","red");
    }
    });
}

function postRegistration(data)
{
    setTimeout(()=>{
    fetch("https://api.mocki.app/v2/sample/register",
    {
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(data)
    })
        .then(response=>response.json())
        .then(result=>
            {
        $("#formMessage").text("Registration submitted!").css("color","green");
        })
        .catch(error=>
        {
        $("#formMessage").text("Submission failed.").css("color","red");
        });
    },1000);
}

function searchEvents(query){
    const filtered=events.filter(e=>e.name.toLowerCase().includes(query.toLowerCase()));
    displayEvents(filtered);
}

$("#registerBtn").click(()=>{
    const userName=$("#userName").val();
    const userEmail=$("#userEmail").val();
    const eventId=$("#eventId").val();
    try{
    const message=registerUser(eventId,userName,userEmail);
    $("#formMessage").text(message).css("color","green");
    displayEvents(events);
    }
    catch(error)
    {
    $("#formMessage").text(error.message).css("color","red");
    }
});

$("#cancelBtn").click(()=>
    {
    const userName=$("#userName").val();
    const eventId=$("#eventId").val();
    try
    {
    const message=cancelRegistration(eventId,userName);
    $("#formMessage").text(message).css("color","green");
    displayEvents(events);
    }
    catch(error)
    {
    $("#formMessage").text(error.message).css("color","red");
    }
});

$("#searchInput").on("keydown",e=>{
    if(e.key==="Enter"){
    searchEvents(e.target.value);
    }
});