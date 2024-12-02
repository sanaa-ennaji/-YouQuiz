#!/usr/bin/env bash
host="$1"
shift
cmd="$@"

until nc -z "$host" 5432; do
  echo "Waiting for PostgreSQL at $host:5432..."
  sleep 2
done

echo "PostgreSQL is up. Executing command..."
exec $cmd
