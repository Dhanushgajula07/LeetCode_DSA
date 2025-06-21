import os
import shutil

# Define keywords and folder names
topics = {
    "Array": "Arrays",
    "String": "Strings",
    "Linked List": "LinkedLists",
    "Tree": "Trees",
    "Graph": "Graphs",
    "Dynamic Programming": "DP",
    "Stack": "Stacks_Queues",
    "Queue": "Stacks_Queues",
    "Bit": "BitManipulation",
    "Backtracking": "Backtracking"
}

# Create folders if not present
for folder in topics.values():
    os.makedirs(folder, exist_ok=True)

# Go through all files in the current directory
for filename in os.listdir("."):
    if filename.endswith(".java"):
        with open(filename, 'r') as f:
            content = f.read()
            for key, folder in topics.items():
                if key.lower() in content.lower():
                    shutil.move(filename, os.path.join(folder, filename))
                    break
