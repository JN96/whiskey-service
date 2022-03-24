#!/bin/bash
docker-compose down
docker system prune -a -f
docker volume prune -f
