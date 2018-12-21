#!/usr/bin/env bash

function set_bash_error_handling() {
    set -euo pipefail
}

function go_to_project_root_directory() {
    local -r script_dir=$( dirname "${BASH_SOURCE[0]}")
    cd "$script_dir/.."
}

function run_tests() {
    local -r test_mode=${1:-}

    ./scripts/run_tests_postgres.sh
    ./scripts/run_tests_mysql.sh
    ./scripts/run_tests_h2.sh
}

function main() {
    set_bash_error_handling
    go_to_project_root_directory

    local -r test_mode=${1:-}

    run_tests "$test_mode"
}

main "$@"
