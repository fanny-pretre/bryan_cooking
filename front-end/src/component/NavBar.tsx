import { useLocation, useNavigate, NavLink } from "react-router-dom";

import {
  AppBar,
  Box,
  Toolbar,
  Typography,
  Button,
  Container,
  BottomNavigation,
  BottomNavigationAction,
  Paper,
} from "@mui/material";

import HomeIcon from "@mui/icons-material/Home";
import RestaurantIcon from "@mui/icons-material/Restaurant";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import KitchenIcon from "@mui/icons-material/Kitchen";

const pages = [
  { label: "Accueil", path: "/dashboard", icon: <HomeIcon /> },
  { label: "Menu", path: "/meal", icon: <RestaurantIcon /> },
  { label: "Planning", path: "/planning", icon: <CalendarMonthIcon /> },
  { label: "Ingrédients", path: "/ingredient", icon: <KitchenIcon /> },
];

function Navbar() {
  const location = useLocation();
  const navigate = useNavigate();

  return (
    <>
      <AppBar
        position="static"
        sx={{
          display: { xs: "none", md: "block" },
          bgcolor: "background.paper",
          color: "text.primary",
          boxShadow: 1,
        }}
      >
        <Container maxWidth="xl">
          <Toolbar disableGutters>
            <Typography
              variant="h6"
              component={NavLink}
              to="/dashboard"
              sx={{
                textDecoration: "none",
                color: "inherit",
                fontWeight: 700,
                flexGrow: 1,
              }}
            >
              Meal Planner
            </Typography>

            <Box sx={{ display: "flex", gap: 1 }}>
              {pages.map((page) => (
                <Button
                  key={page.path}
                  component={NavLink}
                  to={page.path}
                  sx={{
                    borderRadius: 2,
                    px: 2,
                    py: 1,
                    color: "text.primary",
                    textTransform: "none",
                    fontWeight: 600,

                    "&.active": {
                      bgcolor: "primary.main",
                      color: "white",
                    },

                    "&:hover": {
                      bgcolor: "primary.dark",
                      color: "white",
                    },
                  }}
                >
                  {page.label}
                </Button>
              ))}
            </Box>
          </Toolbar>
        </Container>
      </AppBar>

      <Paper
        sx={{
          position: "fixed",
          bottom: 16,
          left: 16,
          right: 16,
          display: { xs: "block", md: "none" },
          borderRadius: 4,
          backdropFilter: "blur(12px)",
          bgcolor: "rgba(255,255,255,0.8)",
          zIndex: 20,
        }}
        elevation={6}
      >
        <BottomNavigation
          value={location.pathname}
          onChange={(event, newValue) => navigate(newValue)}
          showLabels
          sx={{
            bgcolor: "transparent",
          }}
        >
          {pages.map((page) => (
            <BottomNavigationAction
              key={page.path}
              label={page.label}
              value={page.path}
              icon={page.icon}
              sx={{
                "&.Mui-selected": {
                  color: "primary.main",
                },
              }}
            />
          ))}
        </BottomNavigation>
      </Paper>
    </>
  );
}

export default Navbar;
