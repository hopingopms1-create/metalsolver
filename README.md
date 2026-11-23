# Metal Solver (Forge 1.8.9)

Client-side mod jo Metal Detector ke action bar distance se treasure chest ki X/Z location nikalta hai
(2D circle intersection / trilateration). Pehle se coordinates collect karne ki zaroorat nahi.

## Kaise use kare
1. Detector hath me lekar **ruk jao** (movement 0). Ruke hue action bar ki pehli reading turant save hoti hai (chat me `Reading 1`).
   (Server chalte waqt distance sahi update nahi karta, isliye sirf ruke hue reading li jati hai.)
2. 5-6 block door jao, dobara ruko -> `Reading 2` -> 2 **yellow** waypoint.
3. Phir door jao (seedhi line me nahi), ruko -> `Reading 3` -> waypoint **green** hokar lock ho jata hai.
4. Chest ke paas pahunchne par solver khud reset ho jata hai.

## Keybinds (Controls > Metal Solver)
- `R` - reset
- `K` - solver on/off

## Setup (zaroori)
- `MetalSolver.java` me regex `DIST` ko apne server ke exact action bar text ke hisaab se badlo.
- Tuning: `SETTLE_MS` (default 400ms), `LOCK_RMSE`, `MIN_SPREAD`, `MIN_MOVE`, `STILL_EPS`, `MIN_MOVE`, `FOUND_RANGE`.
- Waypoint ka rang/opacity `onRender` me (`fillBox(... 90)` = fill ki darkness).

## Build
Requirements: **JDK 8**, ForgeGradle 2.1 (Gradle 2.14 ke saath best).

```
gradle setupDecompWorkspace
gradle build
```

Jar `build/libs/` me milega -> `.minecraft/mods` me daalo (Forge 1.8.9).

GitHub Actions: repo me `.github/workflows/build.yml` hai, push par jar build hokar Actions > Artifacts me milega.

## Disclaimer
Server ke rules check kar lo ki is tarah ke mods allowed hain ya nahi. Use at your own risk.

## Readings ka flow
Exactly **3 readings** li jati hain. 3rd reading par agar location mil gayi to waypoint **green** hokar lock hota hai.
Agar nahi mili (readings agree nahi karti ya seedhi line me hain) to chat me message aata hai aur solver **dobara reading 1 se** shuru karta hai.

## Debug messages
Chat me solver ke messages (Reading, Reset, Location mil gayi...) default me **band** hain.
Chalu karne ke liye: `/metal debug on`, band karne ke liye: `/metal debug off` (ya sirf `/metal debug` toggle karta hai).
