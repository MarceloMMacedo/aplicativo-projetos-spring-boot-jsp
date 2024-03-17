document.querySelectorAll('.limited-text').forEach(p => {
    if (p.textContent.length > 1500) {
      p.textContent = p.textContent.substring(0, 1500);
    }
  });
