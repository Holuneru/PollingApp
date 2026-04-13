document.addEventListener('DOMContentLoaded', () => {
    const pollsContainer = document.getElementById('polls-container');

    fetch('/api/polls/all')
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(polls => {
            pollsContainer.innerHTML = ''; // Clear the "Loading..." message
            if (!polls || polls.length === 0) {
                pollsContainer.innerHTML = '<p>No polls available at the moment.</p>';
                return;
            }

            polls.forEach(poll => {
                const pollElement = document.createElement('div');
                pollElement.classList.add('poll');

                const question = document.createElement('h2');
                question.textContent = poll.pollName;
                pollElement.appendChild(question);

                if (poll.options && poll.options.length > 0) {
                    poll.options.forEach(option => {
                        const optionElement = document.createElement('div');
                        optionElement.classList.add('option');

                        const optionText = document.createElement('span');
                        optionText.classList.add('option-text');
                        optionText.textContent = option.optionText;
                        optionElement.appendChild(optionText);

                        const voteCount = document.createElement('span');
                        voteCount.classList.add('vote-count');
                        voteCount.textContent = `Votes: ${option.voteCount}`;
                        optionElement.appendChild(voteCount);

                        pollElement.appendChild(optionElement);
                    });
                }

                pollsContainer.appendChild(pollElement);
            });
        })
        .catch(error => {
            console.error('Error fetching polls:', error);
            pollsContainer.innerHTML = '<p>Error loading polls. Please check the console for details.</p>';
        });
});
