function clockRun() {
    const padClock = document.querySelector(".pad-clock");
    setInterval(() => {
        const now = new Date();
        const nowHours = now.getHours();
        const nowMinutes = now.getMinutes() < 10 ? `0${now.getMinutes()}` : now.getMinutes();
        const nowClockText = `${nowHours}:${nowMinutes}`;
        padClock.innerHTML = nowClockText;
    }, 1000);
}

clockRun();