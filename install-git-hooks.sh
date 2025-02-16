#!/bin/sh

# Check if we're in a Git repository
if ! git rev-parse --is-inside-work-tree > /dev/null 2>&1; then
  echo "Error: Not a git repository."
  exit 1
fi

# Create .git/hooks if it doesn't exist
if [ ! -d ".git/hooks" ]; then
  mkdir -p .git/hooks
fi

# Copy the pre-commit hook
cp scripts/git-hooks/pre-commit .git/hooks/pre-commit

# Make the hook executable
chmod +x .git/hooks/pre-commit

echo "Git hooks installed successfully!"