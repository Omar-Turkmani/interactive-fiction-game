# interactive-fiction-game
Interactive fiction game is a text adventure game where you are controlling a character and influencing his environment,
these types of games were first written in the late '70s and were sort of a choose-your-own-adventure book, but for geeks.

More details: https://en.wikipedia.org/wiki/Interactive_fiction

**This project is created for applying Objected-Oriented Programming, Clean Code, and Design Patterns concepts**

## About

 In this game, you will navigate a map (turning east, west, north, south) and move through doors (forward, backward) if they are unlocked and opened until you reach the winning room during a specific time.
 
The map contains more than one room, each room has four walls and each wall may have one element (Mirror, Cabinet, Plate, Door, or Master) or simply be a plain wall   
 
As you navigate through the map, you can look for what your facing wall contains, but be careful you can't look if the room's lighting is off, and not all rooms have lights! so keep the flashlight in your bag

Many items can be acquired as (door's/cabinet's keys, flashlight, and golds), you can acquire them by checking cabinets, plates, mirrors or buying them from master

To unlock locked elements (Doors, Cabinets) the player should have the required key and use it

Wish you a happy escaping from this map :)

### The map :
<div>
    <img  src="https://drive.google.com/thumbnail?id=1Q41DJmpn5fzVrIzo2MJ8ukJpCFPM7zUw&sz=w1000-h1000">
</div>


## How To Play 


To play the game use the following commands :

| Command       | Description  |         
| ------------- | ------------- |
| left     | to turn orientation left |
| right      | to turn orientation right     |
| forward |to enter through a door in front of you     |
| backward |to enter through a door behind you    |
| look |tell you what you are facing or dark if light is off    |
| status |gives which direction the player is and the amount of gold and items that he has    |
| check Door |to check door status    |
| check Mirror |to search behind mirror   |
| check Plate |to search behind plate    |
| check Cabinet |to check cabinet status   |
| open |to open a door    |
| swLights  |turn on the light (if room has switchlights)    |
|use Flashlight |toggle the flashlight status(on if it is off and vesa versa)    |
|use -keyname- Key |this command is used when you're facing a locked door or cabinet you should specify the key you want to use instead of -keyname-    |
|trade |use trade in front of master to buy, sell, list, finish trade with him   |
|restart|will restart the game   |
|quit|will quit the game   |


## Future improvment 

* The game focusing on object orinted design mindset, so map creating is fixed and hard coded, for future may I make it by importing configuration file (JSON, XML) or use <a href="https://en.wikipedia.org/wiki/Builder_pattern#:~:text=The%20builder%20pattern%20is%20a,Gang%20of%20Four%20design%20patterns."> Builder Pattern </a> 
* Show timer on screen
* Add more elements and chellenges to test the code scalability 
