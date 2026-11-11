# Project Name

## Team Information

### Team Members
- Michael Mao
- Michael Olson
- Will Chen

---

## Project Description

### Domain

A fast paced card game that has 3 phases, a variety of cards with unique abilities. The phases are preparation phase, action phase, and battle phase. Decks will consist a few cards, which allows for strategic building of decks to make the most of card abilities and interactions.
---

## User Stories

### As a strategic card gamer, I want a lot of cards to choose from to strategically construct my deck

### As a competitive online gamer, I want to play live online battles against other players my skill level

### As a person with a short attention span, I want to interact with my cards throughout the phases of the battle.

### As a casual gamer, I want to be able to create an account and login to save my decks

(Add additional user stories as needed.)

---

## Use Cases

### The user can queue for a match and will get put in a match when a match is found, matchmaking is based on user's elo - Michael M
### User moves and interactions are sent to their opponent in real time - Michael M

### Battle card interaction use case: user can click card and perform an available action - Michael O
### Battle preparation use case: User can choose a card to play during the preparation phase - Michael O
### ...

### Users are required to create an account or login to access game and their data is stored in a database. Will

### Deck creation: A user can use a deck creation page to build and save their deck. Will

### Weather: Weather (From API) changes affect card properties - Will


(Add additional use cases as needed.)

---

## Minimal Viable Product (MVP)

| Team Member | MVP Use Case |
|-------------|--------------|
| Name | Use Case |
| Name | Use Case |
| Name | Use Case |

---

## Entities

### BattleCard
- int hp
- int atk
- Ability ability


### Ability
- int numFriendly
- int numEnemy
- void doAbility(ArrayList of selected cards)


### Field
- ArrayList<BattleCard> player1Backline
- ArrayList<BattleCard> player1Frontline
- BattleCard player1General
- ArrayList<BattleCard> player2Backline
- ArrayList<BattleCard> player2Frontline
- BattleCard player2General
- ArrayList<BattleCard> graveyard



### Deck
- ArrayList<BattleCard> cards

### User
- String username
- String password
- ArrayList<Deck> decks
- int elo

### Game
- String phase
- String currentPlayer



(Add additional entities as needed.)

---

## API Usage

**API Name:**

**Documentation:** [Link]

**How it is used in the program:**

---

## Design Diagrams

### UML Class Diagram


### Sequence Diagrams

---

## How to Run

[Instructions for running the program.]

---

## Notes

[Any additional project information.]
